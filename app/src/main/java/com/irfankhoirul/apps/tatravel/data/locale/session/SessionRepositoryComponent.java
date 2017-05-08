package com.irfankhoirul.apps.tatravel.data.locale.session;

import com.irfankhoirul.apps.tatravel.ContextModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Irfan Khoirul on 4/16/2017.
 */

@Singleton
@Component(modules = {SessionRepositoryModule.class, ContextModule.class})
public interface SessionRepositoryComponent {

    SessionRepository getSessionRepository();
}