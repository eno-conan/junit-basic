package com.junitbasic.demo.generic;

// Genericsクラス
public class Storage<T> {
    private T item;

    // initializeメソッド（初期化）
    public void initialize(T item) {
        this.item = item;
        System.out.println("Initialized with: " + item);
    }

    // getメソッド（アイテムを取得）
    public T get() {
        return item;
    }

    // clearメソッド（アイテムを削除）
    public void clear() {
        item = null;
        System.out.println("Storage cleared.");
    }

    // isInitializedメソッド（初期化されているか確認）
    public boolean isInitialized() {
        return item != null;
    }

    // 追加するメソッド
    public String describe() {
        if (item == null) {
            return "Storage is empty.";
        }
        return item.toString();
    }

}
