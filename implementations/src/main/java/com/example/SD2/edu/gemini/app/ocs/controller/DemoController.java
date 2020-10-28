//package com.example.SD2.edu.gemini.app.ocs.controller;
//
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.servlet.ModelAndView;
//
//public class DemoController {
//    private CreateScienceController userController = new CreateScienceController();
//    public DemoController(CreateScienceController userController)
//    {this.userController = userController;}
//
//    @RequestMapping(value = "/", method = RequestMethod.GET)
//    public ModelAndView users(){
//
//        ModelAndView database = new ModelAndView("ShowData");
////       set the database info
//        database.addObject("users", userController.getAllScienePlan());
//        //get all user data
//        return database;
//        //return info of database
//    }
//}
