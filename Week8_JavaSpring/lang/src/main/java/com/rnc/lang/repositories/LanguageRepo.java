package com.rnc.lang.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.rnc.lang.models.Language;

public interface LanguageRepo extends CrudRepository<Language, Long> {

	Optional<Language> findById(Long id);

}
