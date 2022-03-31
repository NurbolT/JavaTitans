changes
package com.item.controller;

import com.item.dao.ItemDAO;
import com.item.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ItemController {

    @Autowired
    ItemDAO itemDAO;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView allItems(){
        List<Item> itemList = itemDAO.allItems();
        ModelAndView view = new ModelAndView();
        view.addObject("items", itemList);
        view.setViewName("itemsExample1");
        return  view;
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editPage(@PathVariable(name = "id") Long id){
        Item item = itemDAO.getById(id);
        ModelAndView view = new ModelAndView();
        view.addObject("item",itemExample1);
        view.setViewName("editItems");
        return view;
    }


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addItem(@RequestParam(name = "name") String name,
                         @RequestParam(name = "price") double price){

        itemDAO.add(new Item(null, nameExample1, price));

        return "redirect:/";

    }


public class classExample{
	String name;
	String surname;
	int age;
	String email;
	double gpa;
}