/*
 * Copyright (C) 2015 LAM Creations
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.lamcreations.scaffold.common.activities;

import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.MenuRes;
import android.support.design.widget.BottomNavigationView;
import android.view.View;

import com.lamcreations.scaffold.R;

public abstract class BottomNavigationActivity extends BaseActivity
        implements BottomNavigationView.OnNavigationItemSelectedListener {

    protected BottomNavigationView mBottomNavigationView;
    protected View mContentView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setupBottomNavigationView();
        mContentView = findViewById(R.id.scaffold_content);
    }

    @CallSuper
    protected void setupBottomNavigationView() {
        mBottomNavigationView = findViewById(R.id.scaffold_bottom_navigation_view);
        mBottomNavigationView.inflateMenu(getBottomBarMenuResId());
        mBottomNavigationView.setOnNavigationItemSelectedListener(this);
    }

    @Override
    protected int getActivityLayoutResId() {
        return R.layout.scaffold_activity_bottom_navigation;
    }

    @MenuRes
    protected abstract int getBottomBarMenuResId();
}
