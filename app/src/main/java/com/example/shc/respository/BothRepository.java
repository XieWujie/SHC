package com.example.shc.respository;

public abstract class BothRepository<L extends LocalRepository,R extends RemoteRepository> {
    protected L local;
    protected R remote;

    public BothRepository(L local, R remote) {
        this.local = local;
        this.remote = remote;
    }
}
