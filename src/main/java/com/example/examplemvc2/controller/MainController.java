package com.example.examplemvc2.controller;

import com.example.examplemvc2.dao.DishDao;
import com.example.examplemvc2.model.Dish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
public class MainController {

    @Autowired
    private DishDao dishDao;

    @RequestMapping("/aboutus")
    public String aboutUs() {
        return "aboutus";
    }

    @RequestMapping("/singledish")
    public String singleDish(Map<String, Object> model) {

        Optional<Dish> returnDish = dishDao.findById(1);
        model.put("dish",returnDish.get());

        return "dishdetails";
    }


    @RequestMapping("/dishlist")
    public String dishList(Map<String, Object> model) {

        List<Dish> dishList = dishDao.findAll();
        model.put("dishList", dishList);

        return "dishlist";
    }

    @RequestMapping("/newdish")
    public String newDish() {
        return "newdish";
    }

    @RequestMapping("/submitnewdish")
    public String submitNewDish(@ModelAttribute("dish") Dish dish, Map<String, Object> model) {

        dishDao.create(dish);

        model.put("dish",dish);

        return "dishdetails";
    }

    @RequestMapping("/dishdetails")
    public String dishDetails(@RequestParam("dishIndex") int dishIndex, Map<String, Object> model) {

        if (dishIndex < 0) {
            model.put("errormessage", "You did not select any dish!");
            return "error";
        }

        Optional<Dish> dish = dishDao.findById(dishIndex);
        model.put("dish",dish.get());

        return "dishdetails";
    }

}
