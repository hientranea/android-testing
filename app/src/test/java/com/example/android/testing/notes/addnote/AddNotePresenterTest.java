/*
 * Copyright 2015, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.testing.notes.addnote;

import com.example.android.testing.notes.data.Note;
import com.example.android.testing.notes.data.NotesRepository;
import com.example.android.testing.notes.util.ImageFile;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Unit tests for the implementation of {@link AddNotePresenter}.
 */
public class AddNotePresenterTest {

    @Mock
    private NotesRepository mNotesRepository;

    @Mock
    private ImageFile mImageFile;

    @Mock
    private AddNoteContract.View mAddNoteView;

    private AddNotePresenter mAddNotesPresenter;

    @Before
    public void setupAddNotePresenter() {
        // Mockito has a very convenient way to inject mocks by using the @Mock annotation. To
        // inject the mocks in the test the initMocks method needs to be called.
        MockitoAnnotations.initMocks(this);

        // Get a reference to the class under test
        mAddNotesPresenter = new AddNotePresenter(mNotesRepository, mAddNoteView, mImageFile);
    }

    @Test
    public void saveNoteToRepository_showsSuccessMessageUi() {
        // When the presenter is asked to save a note
        mAddNotesPresenter.saveNote("New Note Title", "Some Note Description");

        // Then a note is,
        verify(mNotesRepository).saveNote(any(Note.class)); // saved to the model
        verify(mAddNoteView).showNotesList(); // shown in the UI
    }

}
