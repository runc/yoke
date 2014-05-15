package com.jetdrone.vertx.yoke.middleware;

import groovy.lang.Closure;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.vertx.java.core.Handler;
import org.vertx.java.core.json.JsonObject;

public class GJWT extends JWT {
    public GJWT() {
        super();
    }

    public GJWT(final @Nullable String skip) {
        super(skip);
    }

    public GJWT(final @Nullable String skip, final Closure closure) {
        super(skip, new JWTHandler() {
            @Override
            public void handle(JsonObject token, Handler<Object> result) {
                closure.call(token.toMap(), result);
            }
        });
    }
}
