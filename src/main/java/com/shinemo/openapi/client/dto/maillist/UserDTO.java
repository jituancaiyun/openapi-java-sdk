package com.shinemo.openapi.client.dto.maillist;

/**
 * Created by yuanjian on 6/12/17.
 */
public class UserDTO {
    private long uid;
    private String mobile;
    private String name;
    private JobGrade jobGrade;

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public JobGrade getJobGrade() {
        return jobGrade;
    }

    public void setJobGrade(JobGrade jobGrade) {
        this.jobGrade = jobGrade;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "uid=" + uid +
                ", mobile='" + mobile + '\'' +
                ", name='" + name + '\'' +
                ", jobGrade=" + jobGrade +
                '}';
    }

    public static class JobGrade {
        private long id;
        private String name;
        private int level;

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getLevel() {
            return level;
        }

        public void setLevel(int level) {
            this.level = level;
        }

        @Override
        public String toString() {
            return "JobGrade{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", level=" + level +
                    '}';
        }
    }
}
