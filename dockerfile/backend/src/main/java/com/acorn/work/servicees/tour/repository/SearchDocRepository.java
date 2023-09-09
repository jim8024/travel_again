package com.acorn.work.servicees.tour.repository;

import com.acorn.work.servicees.tour.doc.SearchDoc;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SearchDocRepository extends ElasticsearchRepository<SearchDoc,String> {

}
