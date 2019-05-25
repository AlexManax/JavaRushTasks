package com.javarush.task.task37.task3708.retrievers;

import com.javarush.task.task37.task3708.cache.LRUCache;
import com.javarush.task.task37.task3708.storage.Storage;

public class CachingProxyRetriever implements Retriever{
    private LRUCache lruCache = new LRUCache(10);
    private OriginalRetriever originalRetriever;


    public CachingProxyRetriever(Storage storage) {
        this.originalRetriever = new OriginalRetriever(storage);
    }

    public Object retrieve(long id) {
        Object o;
        if ((o = lruCache.find(id)) != null) {
//            return o;
        }
        else {
            lruCache.set(id, (o = originalRetriever.retrieve(id)));
        }
        return o;
    }
}
