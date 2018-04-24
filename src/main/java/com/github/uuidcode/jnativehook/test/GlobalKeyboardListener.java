package com.github.uuidcode.jnativehook.test;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.jnativehook.GlobalScreen;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

public class GlobalKeyboardListener implements NativeKeyListener {
    private Robot robot;

    GlobalKeyboardListener() {
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
            this.robot.keyPress(KeyEvent.VK_ALT);
            this.robot.keyPress(KeyEvent.VK_TAB);

            this.robot.keyRelease(KeyEvent.VK_TAB);
            this.robot.keyRelease(KeyEvent.VK_ALT);
        }
    }

    public static void main(String[] args) throws Exception {
        GlobalScreen.registerNativeHook();
        GlobalScreen.addNativeKeyListener(new GlobalKeyboardListener());
    }
}
