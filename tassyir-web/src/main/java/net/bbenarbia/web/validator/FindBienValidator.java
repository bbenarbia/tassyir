package net.bbenarbia.web.validator;

import net.bbenarbia.web.dto.FindBienDTO;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class FindBienValidator  implements Validator {

	@SuppressWarnings("rawtypes")
	@Override
	public boolean supports(Class c) {
		return FindBienDTO.class.isAssignableFrom(c);
	}

	@Override
	public void validate(Object command, Errors errors) {
		if (command.getClass().equals(FindBienDTO.class)) {
			FindBienDTO findBienBean = (FindBienDTO) command;
			
			if (!(findBienBean.getAppartement() || findBienBean.getAgricole()
					|| findBienBean.getCarcasse()
					|| findBienBean.getCommercial()
					|| findBienBean.getMaison()
					|| findBienBean.getTerrain()
					|| findBienBean.getVacances())) {
				errors.rejectValue("maison",
						"typebien.mustatlessone");
			}

			switch (findBienBean.getTypeOperationBien()) {
			case 1:
			case 2:
			case 3:
			case 4:
			case 5:
			case 6:
			case 7:
			case 8:
			case 9:
			case 10:
			case 11:
			case 12:
				break;

			default:
				errors.rejectValue("typeOperationBien",
						"typeOperationBien.notvalid");
				break;
			}
			
			
			if(findBienBean.getDepartementBien() == null || findBienBean.getDepartementBien().isEmpty()){
				errors.rejectValue("departementBien",
						"departementBien.notvalid");
			}
			
			
			
			
			
		}

	}

}