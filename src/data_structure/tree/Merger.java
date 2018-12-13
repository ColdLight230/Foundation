package data_structure.tree;

// 自定义merge方法
public interface Merger<E> {
    E merge(E a, E b);
}
