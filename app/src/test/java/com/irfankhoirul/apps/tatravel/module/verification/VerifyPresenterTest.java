package com.irfankhoirul.apps.tatravel.module.verification;

import com.irfankhoirul.apps.tatravel.data.source.locale.session.Session;
import com.irfankhoirul.apps.tatravel.data.source.remote.user.UserRepositoryImpl;
import com.irfankhoirul.mvp_core.data.IRequestResponseListener;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertNotNull;

/**
 * Created by Irfan Khoirul on 5/17/2017.
 */
public class VerifyPresenterTest {

    private static Map<String, String> VERIFY_DATA;

    @Mock
    private UserRepositoryImpl mUserRepositoryImpl;

    @Mock
    private Session mSessionImpl;

    @Mock
    private VerifyContract.View mVerifyView;

    @Captor
    private ArgumentCaptor<IRequestResponseListener> mRequestListenerCaptor;

    private VerifyPresenter mVerifyPresenter;

    @Before
    public void setupVerifyPresenter() {
        // Mockito has a very convenient way to inject mocks by using the @Mock annotation. To
        // inject the mocks in the test the initMocks method needs to be called.
        MockitoAnnotations.initMocks(this);

        // Get a reference to the class under test
        mVerifyPresenter = new VerifyPresenter(mSessionImpl, mUserRepositoryImpl, mVerifyView);

        // The presenter won't update the view unless it's active.
//        when(mVerifyView.isActive()).thenReturn(true);

        // We start the tasks to 3, with one active and two completed
//        TASKS = Lists.newArrayList(new Task("Title1", "Description1"),
//                new Task("Title2", "Description2", true), new Task("Title3", "Description3", true));
        VERIFY_DATA = new HashMap<>();
        VERIFY_DATA.put("", "");
    }

    @Test
    public void getSessionData_ReturnNotNull() {
        assertNotNull(mSessionImpl);
    }

    @Test
    public void verifyUser_Success() {
//        // Given a stubbed completed task
//        Task task = new Task("Details Requested", "For this task", true);
//        mTasksPresenter.loadTasks(true);
//
//        // When task is marked as activated
//        mTasksPresenter.activateTask(task);
//
//        // Then repository is called and task marked active UI is shown
//        verify(mTasksRepository).activateTask(task);
//        verify(mTasksView).showTaskMarkedActive();
    }

    @Test
    public void verifyUser_Failed() {

    }

    @Test
    public void updateFcmToken_Success() {

    }

}