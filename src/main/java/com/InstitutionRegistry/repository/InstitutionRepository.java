package com.InstitutionRegistry.repository;

import com.InstitutionRegistry.model.Institution;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface InstitutionRepository extends PagingAndSortingRepository<Institution, Long> {
}
