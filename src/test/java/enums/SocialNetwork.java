package enums;

public enum SocialNetwork {

    TWITTER("https://twitter.com/wrike"),
    FACEBOOK("https://www.facebook.com/Wrike"),
    LINKEDIN("https://www.linkedin.com/company/wrike"),
    PINTEREST("https://www.pinterest.com/wriketeam/"),
    YOUTUBE("https://www.youtube.com/user/WrikeTeam"),
    INSTAGRAM("https://www.instagram.com/wriketeam/");

    private final String socialNetwork;

    SocialNetwork(String socialNetwork) {
        this.socialNetwork = socialNetwork;
    }

    public String getSocialNetwork() {
        return socialNetwork;
    }
}
