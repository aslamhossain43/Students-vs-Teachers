package com.renu.s_vs_t.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.renu.s_vs_t.models.ManageCouchingCenter;

public class ImageFileForCouchingValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return ManageCouchingCenter.class.equals(clazz);

	}

	@Override
	public void validate(Object target, Errors errors) {
		ManageCouchingCenter manageCouchingCenter = (ManageCouchingCenter) target;

		if (manageCouchingCenter.getiFile() == null
				|| manageCouchingCenter.getiFile().getOriginalFilename().equals("")) {
			errors.rejectValue("iFile", null, "Please upload a file");
			return;
		}

		if (!(manageCouchingCenter.getiFile().getContentType().equals("image/jpeg")
				|| manageCouchingCenter.getiFile().getContentType().equals("image/png")
				|| manageCouchingCenter.getiFile().getContentType().equals("image/jpg")
				|| manageCouchingCenter.getiFile().getContentType().equals("image/gif"))) {
			errors.rejectValue("iFile", null, "Please upload an image");
			return;

		}

	}

}
