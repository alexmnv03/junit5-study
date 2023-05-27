package com.alex.study.junit.introduction;

import com.alex.study.junit.introduction.extention.GlobalExtention;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(GlobalExtention.class)
public abstract class TestBase {
}
