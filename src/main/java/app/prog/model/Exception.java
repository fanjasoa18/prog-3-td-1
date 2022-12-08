package app.prog.model;

import lombok.Getter;
public class Exception extends RuntimeException{

        @Getter
        private final ExceptionType type;

        public Exception(ExceptionType type, String message) {
            super(message);
            this.type = type;
        }

        public Exception(ExceptionType type, Exception source) {
            super(source);
            this.type = type;
        }

        public enum ExceptionType {
            CLIENT_EXCEPTION,
            SERVER_EXCEPTION
        }
}


