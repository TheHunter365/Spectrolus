package net.thehunter365.spectrolusconnector.protocol.event;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class EventManager {


    private Set<Listener> listeners;

    public EventManager() {
        this.listeners = new HashSet<>();
    }

    public void registerListener(Listener listener) {
        this.listeners.add(listener);
    }

    public void registerPacketListener(PacketListener packetListener) {
        this.listeners.add(packetListener);
    }

    public void unregisterListener(Listener listener) {
        this.listeners.remove(listener);
    }


    public void callPacketEvent(String channel, Event event) {
        listeners.stream().filter(listener -> listener instanceof PacketListener && ((PacketListener)listener).getChannel().equals(channel))
                .collect(Collectors.toSet())
                .forEach(listener -> {
                    Method[] methods = listener.getClass().getDeclaredMethods();
                    for (Method method : methods) {
                        if (isEventHandler(method)) {
                            try {
                                method.invoke(listener, event);
                            } catch (IllegalAccessException | InvocationTargetException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                });
    }

    public void callEvent(Event event) {
        listeners.forEach(listener -> {
            Method[] methods = listener.getClass().getDeclaredMethods();
            for (Method method : methods) {
                if (isEventHandler(method)) {
                    try {
                        method.invoke(listener, event);
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    private boolean isEventHandler(Method method) {
        return method.isAnnotationPresent(EventHandler.class);
    }
}
