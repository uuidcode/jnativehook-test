package com.github.uuidcode.jnativehook.test;

import static java.awt.event.KeyEvent.VK_ALT;
import static java.awt.event.KeyEvent.VK_TAB;

import java.awt.Robot;

import org.jnativehook.GlobalScreen;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

public class GlobalKeyboardListener implements NativeKeyListener {
    private Robot robot;

    public GlobalKeyboardListener() {
        try {
            this.robot = new Robot();
        } catch (Throwable t) {
        }
    }

    public void nativeKeyTyped(NativeKeyEvent nativeKeyEvent) {
    }

    public void nativeKeyPressed(NativeKeyEvent nativeKeyEvent) {
    }

    public void nativeKeyReleased(NativeKeyEvent nativeKeyEvent) {
        if (nativeKeyEvent.getKeyCode() == 2) {
            this.altTab();
        }
    }

    public void altTab() {
        this.typeKeys(VK_ALT, VK_TAB);
    }

    public void typeKeys(int key1, int key2) {
        this.robot.keyPress(key1);
        this.robot.keyPress(key2);
        this.robot.keyRelease(key2);
        this.robot.keyRelease(key1);
    }

    public static void main(String[] args) throws Exception {
        GlobalScreen.registerNativeHook();
        GlobalScreen.addNativeKeyListener(new GlobalKeyboardListener());
    }
}
