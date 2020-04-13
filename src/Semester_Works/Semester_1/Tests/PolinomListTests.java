package Semester_Works.Semester_1.Tests;

import Semester_Works.Semester_1.List.PolinomList;
import Semester_Works.Semester_1.List.PolinomListItem;
import org.junit.Assert;
import org.junit.Test;

public class PolinomListTests {
    @Test
    public void headCaseOfAdd(){
        PolinomList<PolinomListItem> list = new PolinomList<>();
        PolinomListItem item = new PolinomListItem(1, 1, 1, 1);
        list.add(item);
        PolinomList<PolinomListItem> expected = new PolinomList<PolinomListItem>(item.copy());
        Assert.assertEquals(list, expected);
    }

    @Test
    public void addNull(){
        PolinomList<PolinomListItem> list = new PolinomList<>();
        list.add(null);
        PolinomList<PolinomListItem> expected = new PolinomList<PolinomListItem>();
        Assert.assertEquals(list, expected);
    }

    @Test
    public void replaceCaseOfAdd(){
        PolinomListItem item = new PolinomListItem(1, 1, 1, 1);
        PolinomList<PolinomListItem> list = new PolinomList<PolinomListItem>(item);
        PolinomListItem item2 = new PolinomListItem(4, 1, 1,1);
        list.add(item2);
        PolinomList<PolinomListItem> expected = new PolinomList<PolinomListItem>(item2.copy());
        Assert.assertEquals(list, expected);
    }

    @Test
    public void deleteHead(){
        PolinomList<PolinomListItem> list = new PolinomList<PolinomListItem>();
        PolinomListItem item = new PolinomListItem(1, 1, 1, 1);
        list.add(item);
        list.delete(item);
        PolinomList<PolinomListItem> expected = new PolinomList<PolinomListItem>();
        Assert.assertEquals(list, expected);
    }

    @Test
    public void deleteFromEmpty(){
        PolinomList<PolinomListItem> list = new PolinomList<PolinomListItem>();
        PolinomListItem item = new PolinomListItem(1, 1, 1, 1);
        list.delete(item);
        PolinomList<PolinomListItem> expected = new PolinomList<PolinomListItem>();
        Assert.assertEquals(list, expected);
    }

    @Test
    public void deleteNull(){
        PolinomList<PolinomListItem> list = new PolinomList<PolinomListItem>();
        list.delete(null);
        PolinomList<PolinomListItem> expected = new PolinomList<PolinomListItem>();
        Assert.assertEquals(list, expected);
    }

    @Test
    public void deleteCommon(){
        PolinomList<PolinomListItem> list = new PolinomList<PolinomListItem>();
        PolinomListItem item = new PolinomListItem(1, 1, 1, 1);
        PolinomListItem item2 = new PolinomListItem(1, 1, 2, 3);
        PolinomListItem item3 = new PolinomListItem(1, 1, 3, 3);
        list.add(item);
        list.add(item2);
        list.add(item3);
        list.delete(item2);
        PolinomList<PolinomListItem> expected = new PolinomList<PolinomListItem>(item);
        expected.add(item3);
        Assert.assertEquals(list, expected);
    }

    @Test
    public void deleteUnknown(){
        PolinomList<PolinomListItem> list = new PolinomList<PolinomListItem>();
        PolinomListItem item = new PolinomListItem(1, 1, 1, 1);
        PolinomListItem item2 = new PolinomListItem(1, 1, 2, 3);
        PolinomListItem item3 = new PolinomListItem(1, 1, 3, 3);
        list.add(item);
        list.add(item3);
        list.delete(item2);
        PolinomList<PolinomListItem> expected = new PolinomList<PolinomListItem>(item);
        expected.add(item3);
        Assert.assertEquals(list, expected);
    }

    @Test
    public void deleteTail(){
        PolinomList<PolinomListItem> list = new PolinomList<PolinomListItem>();
        PolinomListItem item = new PolinomListItem(1, 1, 1, 1);
        PolinomListItem item3 = new PolinomListItem(1, 1, 3, 3);
        list.add(item);
        list.add(item3);
        list.delete(item3);
        PolinomList<PolinomListItem> expected = new PolinomList<PolinomListItem>(item);
        Assert.assertEquals(list, expected);
    }
}
