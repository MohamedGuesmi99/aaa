package com.example.demo.services;

import java.util.List;

import com.example.demo.entites.Item;


public interface ItemService {

    List<Item> getAllItems();

    Item getItemById(Long id);

    Item createItem(Item item);

    Item updateItem(Long id, Item item);

    void deleteItem(Long id);
}
