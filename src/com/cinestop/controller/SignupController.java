package com.cinestop.controller;

import org.springframework.stereotype.Controller;

@Controller
public class SignupController {
	
//	@Autowired
//	private DBQuery dbQuery;
//	
//	@RequestMapping(value = "/signup", method = RequestMethod.GET)
//	public ModelAndView showSignupPage() {
//		ModelAndView mav = new ModelAndView("signup");
//		mav.addObject("user", UserModel.builder().userName(null).password(null).build());
//		return mav;
//	}
//	
//	@RequestMapping(value = "/checkUsername", method = RequestMethod.POST)
//	public ResponseEntity<?> checkUserNameAvailability(@RequestBody List<UserModel> userModel) throws SQLException, ClassNotFoundException {
//		ResultSet rs = dbQuery.checkUsernameAvailability(userModel.get(0).getUserName());
//		if (!rs.isBeforeFirst()) {
//			return new ResponseEntity<Object>(HttpStatus.OK);
//		} else {
//			return new ResponseEntity<Object>(HttpStatus.CONFLICT);
//		}
//	}
//
//	@RequestMapping(value = "/addNewUser", method = RequestMethod.POST)
//	public ResponseEntity<Object> registetUser(@RequestBody List<UserModel> userModel) throws ClassNotFoundException, SQLException {
//		dbQuery.persistSignUpInfo(userModel.get(0));		
//		return new ResponseEntity<Object>(HttpStatus.OK);
//	}
}
