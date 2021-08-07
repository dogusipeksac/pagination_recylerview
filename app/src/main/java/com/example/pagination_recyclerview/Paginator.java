package com.example.pagination_recyclerview;

import java.util.ArrayList;

public class Paginator {
    public static final int TOTAL_NUM_ITEMS=5;
        public static final int ITEMS_PER_PAGE=1;
        public static final int ITEMS_REMAINING=TOTAL_NUM_ITEMS % ITEMS_PER_PAGE;
        public static final int LAST_PAGE=TOTAL_NUM_ITEMS / ITEMS_PER_PAGE;


    public ArrayList<ListItem> generatePage(int currentPage){

        int startItem=currentPage*ITEMS_PER_PAGE+1;
        int numOfData=ITEMS_PER_PAGE;

        ArrayList<ListItem> pageData=new ArrayList<>();
         /*   List<ListItem> addList(){

        }
        return listItems;
    }*/

        if(currentPage==LAST_PAGE && ITEMS_REMAINING>0)
        {
            for(int i=startItem;i<startItem+ITEMS_REMAINING;i++) {

                ListItem listItem = new ListItem("Heading" + i,
                        "Description" + i);
                pageData.add(listItem);
            }
        }
        else
        {
            for(int i=startItem;i<startItem+numOfData;i++){
                ListItem listItem=new ListItem("Heading"+i,
                        "Description"+i);
                pageData.add(listItem);
            }
        }

        return pageData;
    }


}
