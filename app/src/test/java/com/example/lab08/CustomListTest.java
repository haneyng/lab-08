package com.example.lab08;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class CustomListTest {

    private CustomList mockCustomList() {
        CustomList CustomList = new CustomList();
        CustomList.addCity(mockCity());
        return CustomList;
    }
    private City mockCity() {
        return new City("Edmonton", "Alberta");
    }

    @Test
    public void testHasCity() {
        CustomList list = new CustomList();
        City calgary = new City("Calgary", "AB");
        list.addCity(calgary);
        // This will fail initially because hasCity() doesn't exist
        assertTrue(list.hasCity(calgary));
    }

    @Test
    void testDeleteCity() {
        // add mock data
        CustomList CustomList = mockCustomList();
        City city1 = new City("Canmore", "Alberta");
        CustomList.addCity(city1);

        // make sure there's 1 city + mockCity in CustomList
        assertEquals(2, CustomList.getCities().size());

        // delete city1
        CustomList.deleteCity(city1);

        // if city1 is deleted, size should be 0 + mockCity
        assertEquals(1, CustomList.getCities().size());
        // if city1 is deleted, it shouldn't be there anymore
        assertFalse(CustomList.hasCity(city1));
    }

    @Test
    void testDeleteException() {
        // add mock data
        CustomList CustomList = mockCustomList();

        // attempt an illegal deletion
        City city = new City("Yellowknife", "Northwest Territories");

        assertThrows(RuntimeException.class, () -> {
            CustomList.deleteCity(city);
        });
}
