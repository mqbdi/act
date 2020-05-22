package jact;

import java.util.List;

public interface IMemory {

    <T> T read(T example);

    <T> List<T> readAll(T example);

    <T> void write(T meme);

}
