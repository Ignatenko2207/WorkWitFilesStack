package com.stdstack.model;

public class ConnectionInfo {

    private Integer sessionId;
    private String ip;
    private Long connectionTime;

    public ConnectionInfo(Integer sessionId, String ip, Long connectionTime) {
        this.sessionId = sessionId;
        this.ip = ip;
        this.connectionTime = connectionTime;
    }

    public ConnectionInfo() {
    }

    public Integer getSessionId() {
        return sessionId;
    }

    public void setSessionId(Integer sessionId) {
        this.sessionId = sessionId;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Long getConnectionTime() {
        return connectionTime;
    }

    public void setConnectionTime(Long connectionTime) {
        this.connectionTime = connectionTime;
    }

    @Override
    public String toString() {
        return sessionId + " " + connectionTime + " " + ip;
    }
}
