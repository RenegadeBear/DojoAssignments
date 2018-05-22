package com.rnc.lang.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.rnc.lang.models.Language;
import com.rnc.lang.repositories.LanguageRepo;

@Service
public class LanguageService {
	
	private LanguageRepo languageRepo;
	
	public LanguageService(LanguageRepo languageRepo) {
		this.languageRepo = languageRepo;
	}

	public Language create(Language language) {
		return languageRepo.save(language);
		
	}
	public ArrayList<Language> all() {
		return (ArrayList<Language>) languageRepo.findAll();
	}
	
	public Language findLanguageById(Long id) {
		Optional<Language> optionalLanguage = languageRepo.findById(id);
		if (optionalLanguage.isPresent()) {
			return optionalLanguage.get();
		}
		else {
			return null;
		}
	}

	public void destroyLanguage(Long id) {
		languageRepo.delete(id);
	}
	
	public void updateLanguage(Language language) {
		languageRepo.save(language);
	}
	
}
