package com.restaurantmanagement.Reena.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurantmanagement.Reena.entity.MenuItem;
import com.restaurantmanagement.Reena.repository.MenuItemRepository;

@Service
public class MenuItemService {

    @Autowired
    private MenuItemRepository menuItemRepository;

    public List<MenuItem> getAllMenuItems() {
        return menuItemRepository.findAll();
    }

    public MenuItem getMenuItemById(Long id) {
        Optional<MenuItem> menuItemOptional = menuItemRepository.findById(id);
        return menuItemOptional.orElse(null);
    }

    public MenuItem saveMenuItem(MenuItem menuItem) {
        return menuItemRepository.save(menuItem);
    }

    public MenuItem updateMenuItem(Long id, MenuItem menuItemDetails) {
        Optional<MenuItem> optionalMenuItem = menuItemRepository.findById(id);
        if (optionalMenuItem.isPresent()) {
            MenuItem existingMenuItem = optionalMenuItem.get();
            existingMenuItem.setName(menuItemDetails.getName());
            existingMenuItem.setDescription(menuItemDetails.getDescription());
            existingMenuItem.setPrice(menuItemDetails.getPrice());
            // Update other fields as needed
            return menuItemRepository.save(existingMenuItem);
        }
        return null; // or throw an exception
    }

    public boolean deleteMenuItem(Long id) {
        Optional<MenuItem> optionalMenuItem = menuItemRepository.findById(id);
        if (optionalMenuItem.isPresent()) {
            menuItemRepository.delete(optionalMenuItem.get());
            return true;
        }
        return false; // or throw an exception
    }
}
