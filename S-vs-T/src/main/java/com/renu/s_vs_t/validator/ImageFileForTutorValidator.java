package com.renu.s_vs_t.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.renu.s_vs_t.models.ManageTutor;

public class ImageFileForTutorValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return ManageTutor.class.equals(clazz);
		
	}

	@Override
	public void validate(Object target, Errors errors) {
		ManageTutor manageTutor = (ManageTutor) target;

		if (manageTutor.getiFile() == null || manageTutor.getiFile().getOriginalFilename().equals("")) {
			errors.rejectValue("iFile", null, "Please upload a file");
			return;
		}

		if (!(manageTutor.getiFile().getContentType().equals("image/jpeg")
				|| manageTutor.getiFile().getContentType().equals("image/png")
				|| manageTutor.getiFile().getContentType().equals("image/jpg")
				|| manageTutor.getiFile().getContentType().equals("image/gif"))) {
			errors.rejectValue("iFile", null, "Please upload an image");
			return;

		}

	}

}
