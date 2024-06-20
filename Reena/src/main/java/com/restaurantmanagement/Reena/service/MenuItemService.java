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

    public List<MenuItem> findAll() {
        return menuItemRepository.findAll();
    }

    public Optional<MenuItem> findById(Long id) {
        return menuItemRepository.findById(id);
    }

    public MenuItem save(MenuItem menuItem) {
        return menuItemRepository.save(menuItem);
    }

    public void deleteById(Long id) {
        menuItemRepository.deleteById(id);
    }
}
