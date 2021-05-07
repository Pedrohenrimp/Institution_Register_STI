package com.InstitutionRegistry.repository;

import com.InstitutionRegistry.model.Institution;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.*;

public interface InstitutionRepository extends PagingAndSortingRepository<Institution, Long> {
    List<Institution> findByNameLike(String string);
}
