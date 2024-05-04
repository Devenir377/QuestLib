package com.scape05.game.entity.storage;

public class Storage {

    public static final class Permanent {

        public static final class Var {

            private final int index;
            private final int offset;
            private final int mask;
            private final boolean transmit;

            /**
             * Creates a new private variable that <b>will not</b> be transmitted to the client.
             *
             * @param index the variable index.
             */
            public Var(int index) {
                this(index, false);
            }

            /**
             * Creates a new permanent variable that can optionally be transmitted to the client.
             *
             * @param index    the index.
             * @param transmitVarToClient whether to transmit on change.
             */
            public Var(int index, boolean transmitVarToClient) {
                this(index, 32, 0, transmitVarToClient);
            }

            /**
             * A verbose constructor for a permanent variable that <b>will</b> be transmitted to the client.
             *
             * @param index   the index.
             * @param bitSize the bitSize in bits.
             * @param offset  the offset.
             */
            public Var(int index, int bitSize, int offset) {
                this(index, bitSize, offset, true);
            }

            /**
             * A verbose constructor for a permanent variable.
             * <p>
             * A single variable has 32 bits of available space which can be allocated in blocks of bits.
             * For example, a single variable slot can store four 8 bit values. The following code would be how:
             * <p>
             * VAR1 = new Var(666, 8, 0, false)
             * VAR2 = new Var(666, 8, 8, false)
             * VAR3 = new Var(666, 8, 16, false)
             * VAR4 = new Var(666, 8, 24, false)
             *
             * @param index    the index.
             * @param bitSize  the bitSize in bits.
             * @param offset   the offset.
             * @param transmitToClient whether to transmit on change.
             */
            public Var(int index, int bitSize, int offset, boolean transmitToClient) {
                this.index = index;
                this.offset = offset;
                this.mask = (int) ((1L << bitSize) - 1) << offset;
                this.transmit = transmitToClient;
            }


        }
    }
}
