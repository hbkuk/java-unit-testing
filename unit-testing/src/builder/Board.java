package builder;

public class Board {
    private final long idx;
    private final String title;
    private final String content;
    private final String writer;
    private final int hit;

    public static class Builder {
        // 필수 인자
        private final String title;
        private final String writer;

        // 기본값
        private long idx = 0;
        private String content = "";
        private int hit = 0;

        public Builder(String title, String writer) {
            this.title = title;
            this.writer = writer;
        }

        public Builder idx(long idx) {
            this.idx = idx;
            return this;
        }

        public Builder content(String content) {
            this.content = content;
            return this;
        }

        public Builder hit(int hit) {
            this.hit = hit;
            return this;
        }

        public Board builder() {
            return new Board(this);
        }
    }

    private Board(Builder builder) {
        idx = builder.idx;
        title = builder.title;
        content = builder.content;
        writer = builder.writer;
        hit = builder.hit;
    }

    public long getIdx() {
        return idx;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getWriter() {
        return writer;
    }

    public int getHit() {
        return hit;
    }
}
