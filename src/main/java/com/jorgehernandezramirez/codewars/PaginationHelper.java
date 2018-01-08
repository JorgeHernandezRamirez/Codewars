package com.jorgehernandezramirez.codewars;

import java.util.List;

public class PaginationHelper<I> {

    private final List<I> collection;

    private final Integer itemsPerPage;

    /**
     * The constructor takes in an array of items and a integer indicating how many
     * items fit within a single page
     */
    public PaginationHelper(List<I> collection, int itemsPerPage) {
        this.collection = collection;
        this.itemsPerPage = itemsPerPage;
    }

    /**
     * returns the number of items within the entire collection
     */
    public int itemCount() {
        return collection.size();
    }

    /**
     * returns the number of pages
     */
    public int pageCount() {
        return (int)Math.ceil(Double.valueOf(collection.size()) / Double.valueOf(itemsPerPage));
    }

    /**
     * returns the number of items on the current page. page_index is zero based.
     * this method should return -1 for pageIndex values that are out of range
     */
    public int pageItemCount(final int pageIndex) {
        if(pageIndex < 0){
            return -1;
        }
        Integer initIndexInclusive = pageIndex * itemsPerPage;
        if(initIndexInclusive >= collection.size()){
            return -1;
        }
        Integer endIndexExclusive = initIndexInclusive + itemsPerPage;
        if(endIndexExclusive > collection.size()){
            endIndexExclusive = collection.size();
        }
        return endIndexExclusive - initIndexInclusive;
    }

    /**
     * determines what page an item is on. Zero based indexes
     * this method should return -1 for itemIndex values that are out of range
     */
    public int pageIndex(int itemIndex) {
        if(itemIndex >= collection.size() || itemIndex < 0){
            return -1;
        }
        return itemIndex / itemsPerPage;
    }
}
