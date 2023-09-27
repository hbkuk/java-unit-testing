package enum_extension.file;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class File {
    private static final List<String> EXTENSIONS = Arrays.asList("PNG", "JPEG", "BMP", "GIF", "JPG");

    private final long FileIdx;
    private final String FileName;
    private final long FileSize;

    public File(Builder builder) {
        this.FileIdx = builder.fileIdx;
        this.FileName = builder.fileName;
        this.FileSize = builder.fileSize;
    }

    public static class Builder {
        private long fileIdx = 0;
        private String fileName;
        private long fileSize;

        public Builder(){};

        public Builder fileIdx(long fileIdx) {
            this.fileIdx = fileIdx;
            return this;
        }
        public Builder FileName(String fileName) {
            this.fileName = fileName;
            return this;
        }
        public Builder fileSize(long fileSize) {
            this.fileSize = fileSize;
            return this;
        }

        public File build() {

            Pattern pattern = Pattern.compile("\\.(\\w+)$");
            Matcher matcher = pattern.matcher(fileName);

            if (!matcher.find()) {
                throw new IllegalArgumentException("유효한 파일이 아닙니다.");
            }

            String extension = matcher.group(1).toUpperCase();

            if (!EXTENSIONS.contains(extension)) {
                throw new IllegalArgumentException("유효하지 않은 확장자입니다.");
            }

            if (fileSize >= 10_485_760) {
                throw new IllegalArgumentException("이미지의 크기가 10_485_760 byte 이상일 수 없습니다.");
            }

            return new File(this);
        }
    }
}
