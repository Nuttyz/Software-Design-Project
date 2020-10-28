package com.example.SD2.edu.gemini.app.ocs.controller;
//import com.example.SD2.edu.gemini.app.ocs.example.MySciencePlan;

import com.example.SD2.edu.gemini.app.ocs.model.*;
import com.example.SD2.edu.gemini.app.ocs.model.VirtualTelescope;
import com.example.SD2.edu.gemini.app.ocs.repository.ImageStarRepository;
import com.example.SD2.edu.gemini.app.ocs.repository.PlanTested;
import com.example.SD2.edu.gemini.app.ocs.repository.SciencePlanRepository;
import com.example.SD2.edu.gemini.app.ocs.repository.UserRepository;
import jparsec.ephem.Target;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

@Controller
public class CreateScienceController {
    @Autowired
    private SciencePlanRepository sciencePlanRepository;

    @Autowired
    private ImageStarRepository imageStarRepository;

    @Autowired
    private PlanTested planTestedRepository;

//    private AstronomicalDataRepository astronomicalDataRepository;

    // Add User link
    // http://localhost:8080/add?id=1&name=Sirichoke%20Yooyen&username=Amzky101&password=123456&role=Science%20Observer
    // http://localhost:8080/add?id=2&name=Nuttapon%20Rungruang&username=Nty000&password=123456&role=Astronomer
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/add")
    public @ResponseBody
    String addNewUser(
            @RequestParam int id
            , @RequestParam String name
            , @RequestParam String username
            , @RequestParam String password
            , @RequestParam String role) {

        if (role.equals("Science Observer")) {
            ScienceObserver sc = new ScienceObserver();
            sc.setId(id);
            sc.setName(name);
            sc.setUsername(username);
            sc.setPassword(password);
            sc.setRole(role);

            userRepository.save(sc);
            return "Saved: " + sc;
        } else if (role.equals("Astronomer")) {
            Astronomer as = new Astronomer();
            as.setId(id);
            as.setName(name);
            as.setUsername(username);
            as.setPassword(password);
            as.setRole(role);

            userRepository.save(as);
            return "Saved: " + as;
        }
        return "Error: invalid username or password";
    }

    @CrossOrigin
    @GetMapping("/login")
    public @ResponseBody
    Iterable<User> getAllUsers() {
        return this.userRepository.findAll();
    }

    @CrossOrigin
    @PostMapping({"/add2"})
    @ResponseBody
    public String BaseSciencePlan(@RequestBody Map<String, Object> body) {
        System.out.println("from user:= " + body);
        BaseSciencePlan h = this.createNewBaseSciencePlan(Integer.parseInt(body.get("id").toString()), body);
        checkDuplicateSciencePlan(h);
//            this.sciencePlanRepository.save(h);
        System.out.println("Result after add:= " + checkDuplicateSciencePlan(h));
//        return checkDuplicateSciencePlan(h);

        return "Saved";

    }

    private BaseSciencePlan createNewBaseSciencePlan(int id, Map<String, Object> body) {
        BaseSciencePlan h = new BaseSciencePlan();
        h.setPlanNo(id);
        System.out.println("id:= " + id);
        return this.setSciencePlanInfo(h, body);
    }

    private BaseSciencePlan setSciencePlanInfo(BaseSciencePlan mySP, Map<String, Object> body) {

        mySP.setCreator(body.get("creator").toString());
        mySP.setSubmitter(body.get("submitter").toString());
        mySP.setFundingInUSD(Double.parseDouble(body.get("fundingInUSD").toString()));
        mySP.setObjectives(body.get("objectives").toString());

        mySP.setStartDate(body.get("startDate").toString());
        System.out.println("Result = " + mySP.getStartDate());
        mySP.setEndDate(body.get("endDate").toString());

        String a = body.get("starSystem").toString();
        Target.TARGET t = Target.TARGET.valueOf(a);
        mySP.setStarSystem(t);

        String pizzaEnumValue = body.get("telescopeLocation").toString();
        BaseSciencePlan.TELESCOPELOC valueTele = BaseSciencePlan.TELESCOPELOC.valueOf(pizzaEnumValue);
        mySP.setTelescopeLocation(valueTele);
        mySP.setDurutionOfObservation(Integer.parseInt(body.get("durutionOfObservation").toString()));

        mySP.setStatus(BaseSciencePlan.STATUS.RUNNING);
        String file = body.get("fileType").toString();
        DataProcRequirement.TYPE filetype = DataProcRequirement.TYPE.valueOf(file);
        mySP.setFileType(filetype);
        mySP.setFileQuality(Double.parseDouble(body.get("fileQuality").toString()));
        mySP.setBw(Double.parseDouble(body.get("bw").toString()));
        mySP.setColors(Double.parseDouble(body.get("colors").toString()));
        mySP.setContrast(Double.parseDouble(body.get("contrast").toString()));
        mySP.setBrightness(Double.parseDouble(body.get("brightness").toString()));
        mySP.setSaturation(Double.parseDouble(body.get("saturation").toString()));

        return mySP;
    }


    public String checkDuplicateSciencePlan(BaseSciencePlan sc) {
        int i = 0;
        if (sciencePlanRepository != null) {
            for (BaseSciencePlan x : getAllScienePlan()) {
                if (x.equals(sc) == true) {
                    i = 1;
                }
            }
        }
        if (i == 0) {
            sciencePlanRepository.save(sc);
            return "Saved";
        } else {
            return "Cannot add";
        }
    }

    @CrossOrigin
    @GetMapping("/all")
    public @ResponseBody
    Iterable<BaseSciencePlan> getAllScienePlan() {
        return this.sciencePlanRepository.findAll();
    }

    @GetMapping("/getID")
    public @ResponseBody
    BaseSciencePlan getId(@RequestParam Integer id) {
        return sciencePlanRepository.findById(id).orElseThrow(() -> new scienceplanNotfound(id));
    }

    @CrossOrigin
    @PutMapping({"/updateStatus/{id}"})
    @ResponseBody
    public String updateSciencePlan(@PathVariable("id") int id, @RequestBody Map<String, Object> body) {
//        System.out.println("updateStatus");
        BaseSciencePlan h = this.updateStatusValidation(Integer.parseInt(body.get("id").toString()), body);
        this.sciencePlanRepository.save(h);
        return "Saved: " + h;
    }

    private BaseSciencePlan updateStatusValidation(int id, Map<String, Object> body) {

//        this.superhumanRepository.deleteById(id);
        BaseSciencePlan sc = sciencePlanRepository.findById(id).get();
        System.out.println("updateStatus");

        return this.setStatusValidation(sc, body);
    }

    private BaseSciencePlan setStatusValidation(BaseSciencePlan mySP, Map<String, Object> body) {

        String b = body.get("statusValidate").toString();
        System.out.println("updateStatus = " + b);
        BaseSciencePlan.STATUS c = BaseSciencePlan.STATUS.valueOf(b);
        mySP.setStatus(c);
        return mySP;
    }

    @CrossOrigin
    @PutMapping({"/updateSubmit/{id}"})
    @ResponseBody
    public String updateSciencePlanupdateSubmit(@PathVariable("id") int id, @RequestBody Map<String, Object> body) {
        System.out.println("updateStatus");
        BaseSciencePlan h = this.updateSubmit(Integer.parseInt(body.get("id").toString()), body);
        this.sciencePlanRepository.save(h);
        return "Saved: " + h;
    }

    private BaseSciencePlan updateSubmit(int id, Map<String, Object> body) {
//        this.superhumanRepository.deleteById(id);
        BaseSciencePlan sc = sciencePlanRepository.findById(id).get();

        return this.setStatusSubmit(sc, body);
    }

    private BaseSciencePlan setStatusSubmit(BaseSciencePlan mySP, Map<String, Object> body) {
        String b = body.get("statusValidate").toString();
        BaseSciencePlan.STATUS c = BaseSciencePlan.STATUS.valueOf(b);
        mySP.setStatus(c);
        mySP.setSubmitter(body.get("submitter").toString());

        return mySP;
    }


    @CrossOrigin
    @GetMapping("/displayimg")
    public @ResponseBody
    Iterable<ImageStar> getAllImageStar() {
//        System.out.println("imageStarRepository:= " + imageStarRepository.count());
        if (imageStarRepository.count() == 0) {
            AstronomicalData a = new AstronomicalData();
            try {
                ArrayList<String> listOfImages = a.getImageStars();
                ImageStar is = new ImageStar();
                int c = 1;
                for (String i : listOfImages) {
                    is.setId(c);
                    is.setImageLink(i);
                    this.imageStarRepository.save(is);
                    c += 1;
                    if (c == 22)
                        break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return this.imageStarRepository.findAll();
    }


    @CrossOrigin
    @PostMapping({"/addImage"})
    @ResponseBody
    public String AddImage(@RequestBody Map<String, Object> body) {

        System.out.println("add image user:= " + body);
        AstronomicalDataAdapter h = this.createAstronomicalData(Integer.parseInt(body.get("id").toString()), body);
        System.out.println("h:= " + h);
        this.planTestedRepository.save(h);
        return "Saved: " + h;
    }

    private AstronomicalDataAdapter createAstronomicalData(int id, Map<String, Object> body) {
        AstronomicalDataAdapter h = new AstronomicalDataAdapter();
        System.out.println("id:= " + id);
        h.setPlanNo(id);
        return this.setAstronomicalData(h, body);
    }

    private AstronomicalDataAdapter setAstronomicalData(AstronomicalDataAdapter myAS, Map<String, Object> body) {
        myAS.setImagefile(body.get("image").toString());
        myAS.setComment(body.get("comment").toString());
        myAS.setAngle(Integer.parseInt(body.get("angle").toString()));
        myAS.setValidity(body.get("valid").toString());
        myAS.setTelescope(body.get("telescope").toString());
        myAS.setConstellation(body.get("starSystem").toString());
        return myAS;
    }


    @CrossOrigin
    @PutMapping({"/operate/{id}"})
    @ResponseBody
    public String Operate(@RequestBody Map<String, Object> body, @PathVariable String id) {
        System.out.println("operate user:= " + body);

        AstronomicalDataAdapter h = this.createOperateData(Integer.parseInt(body.get("id").toString()), body);

//        System.out.println("h:= " + h);
//        this.planTestedRepository.save(h);

        return "Saved: " + h;
    }

    private AstronomicalDataAdapter createOperateData(int id, Map<String, Object> body) {
        AstronomicalDataAdapter h = new AstronomicalDataAdapter();
        System.out.println("id:= " + id);
        BaseSciencePlan sc = sciencePlanRepository.findById(id).get();
        h.setPlanNo(id);
        return this.setOperateData(h, body, sc);
    }

    private AstronomicalDataAdapter setOperateData(AstronomicalDataAdapter myAS, Map<String, Object> body, BaseSciencePlan sc) {
        myAS.setTelescope(body.get("telescope").toString());
        String tele = body.get("telescope").toString();
        VirtualTelescope vt = VirtualTelescopeHandler.getVirtualTelescope(VirtualTelescope.NORTH);
        if (tele.contains("NORTH")) {
            vt = VirtualTelescopeHandler.getVirtualTelescope(VirtualTelescope.NORTH);
        } else {
            vt = VirtualTelescopeHandler.getVirtualTelescope(VirtualTelescope.SOUTH);
        }

        boolean x = false;
        try {
            x = vt.executeSciencePlan();
        } catch (VirtualTelescope.NoSciencePlanException e) {
            e.printStackTrace();
        }
        if (x == false) {
            System.out.println("STATUS:= REJECTED");
            sc.setStatus(BaseSciencePlan.STATUS.REJECTED);
        } else {
            System.out.println("STATUS:= OPERATED");
            sc.setStatus(BaseSciencePlan.STATUS.OPERATED);
        }
        System.out.println("STATUS:= " + x);
        myAS.setOperateResult(x);
        sciencePlanRepository.save(sc);
        return myAS;
    }

    @CrossOrigin
    @GetMapping("/displayTested")
    public @ResponseBody
    Iterable<AstronomicalDataAdapter> getAllAstronomicalDataAdapter() {
        return this.planTestedRepository.findAll();
    }
}
