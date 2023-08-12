package com.xiaohansong.kvstore.model.sstable;

import kvstore.model.command.Command;
import kvstore.model.command.RmCommand;
import kvstore.model.command.SetCommand;
import kvstore.model.sstable.SsTable;
import org.junit.Test;

import java.util.TreeMap;

public class SsTableTest {

    @Test
    public void createFromIndex() {
        TreeMap<String, Command> index = new TreeMap<>();
        for (int i = 0; i < 10; i++) {
            SetCommand setCommand = new SetCommand("key" + i, "value" + i);
            index.put(setCommand.getKey(), setCommand);
        }
        index.put("key100", new SetCommand("key100", "value100"));
        index.put("key100", new RmCommand("key100"));
        SsTable ssTable = SsTable.createFromIndex("test.txt", 3, index);
    }

    @Test
    public void query() {
        SsTable ssTable = SsTable.createFromFile("test.txt");
        System.out.println(ssTable.query("key0"));
        System.out.println(ssTable.query("key5"));
        System.out.println(ssTable.query("key9"));
        System.out.println(ssTable.query("key100"));
    }
}