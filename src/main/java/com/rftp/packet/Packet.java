package com.rftp.packet;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class Packet {

    public static final byte TYPE_DATA = 1;
    public static final byte TYPE_ACK = 2;
    public static final byte TYPE_FIN = 3;

    private static final int HEADER_SIZE = 10;

    private byte version;
    private byte type;
    private int sequenceNumber;
    private int payloadlength;
    private byte[] payload;

    public Packet(byte version, byte type, int sequenceNumber, byte[] payload) {
        this.version = version;
        this.type = type;
        this.sequenceNumber = sequenceNumber;
        this.payloadlength = payload.length;
        this.payload = payload;
    }

    public byte[] toBytes(){
        ByteBuffer buffer = ByteBuffer.allocate(HEADER_SIZE + payload.length);
        buffer.order(ByteOrder.BIG_ENDIAN);
        buffer.put(version);
        buffer.put(type);
        buffer.putInt(sequenceNumber);
        buffer.putInt(payloadlength);
        buffer.put(payload);
        return buffer.array();
    }

    public static Packet fromBytes(byte[] data, int length) {
        ByteBuffer buffer = ByteBuffer.wrap(data, 0 , length);
        buffer.order(ByteOrder.BIG_ENDIAN);
        byte version = buffer.get();
        byte type = buffer.get();
        int sequenceNumber = buffer.getInt();
        int payloadlength = buffer.getInt();
        byte[] payload = new byte[payloadlength];
        buffer.get(payload);
        return new Packet(version, type, sequenceNumber, payload);
    }



    public int getPayloadlength() {
        return payloadlength;
    }
    public byte getVersion() {
        return version;
    }
    public byte getType() {
        return type;
    }
    public int getSequenceNumber() {
        return sequenceNumber;
    }

    public byte[] getPayload() {
        return payload;
    }
}
