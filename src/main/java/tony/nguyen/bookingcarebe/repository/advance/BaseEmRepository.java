package tony.nguyen.bookingcarebe.repository.advance;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import jakarta.persistence.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class BaseEmRepository {
    @PersistenceContext
    protected final EntityManager em;
    private final ObjectMapper objectMapper;

    public BaseEmRepository(EntityManager em) {
        this.em = em;
        objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    public static List<Map<String, Object>> convertTuplesToMap(List<?> tuples) {
        List<Map<String, Object>> result = new ArrayList<>();
        tuples.forEach(object -> {
            if (object instanceof Tuple single) {
                Map<String, Object> tempMap = new HashMap<>();
                for (TupleElement<?> key : single.getElements()) {
                    tempMap.put(key.getAlias(), single.get(key));
                }
                result.add(tempMap);
            } else {
                throw new RuntimeException("Query should return instance of Tuple");
            }
        });

        return result;
    }

    public <T> List<T> parseResult(List<?> list, Class<T> clz) {
        List<T> result = new ArrayList<>();
        convertTuplesToMap(list).forEach(map -> {
            result.add(objectMapper.convertValue(map, clz));
        });
        return result;
    }

    public <T> Page<T> parsePageResult(Query query, Query countQuery, Pageable pageable, Class<T> clz) {
        Long totalRecords = ((Number) countQuery.getSingleResult()).longValue();
        query.setFirstResult(pageable.getPageNumber());
        query.setMaxResults(pageable.getPageSize());
        List<T> result = new ArrayList<>();
        convertTuplesToMap(query.getResultList()).forEach(map -> {
            result.add(objectMapper.convertValue(map, clz));
        });
        return new PageImpl<>(result, pageable, totalRecords);
    }

    public Query createNativeQuery(String query) {
        return this.em.createNativeQuery(query, Tuple.class);
    }

    public void flushAndClear() {
        em.flush();
        em.clear();
    }
}
