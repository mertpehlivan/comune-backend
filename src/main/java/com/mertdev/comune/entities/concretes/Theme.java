package com.mertdev.comune.entities.concretes;

import com.mertdev.comune.entities.concretes.embeddable.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "themes")
public class Theme {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Embedded
        @AttributeOverrides({
                @AttributeOverride(name = "bgColor", column = @Column(name = "background_bg_color"))
        })
        private Background background;

        @Embedded
        @AttributeOverrides({
                @AttributeOverride(name = "bgColor", column = @Column(name = "community_bar_bg_color")),
                @AttributeOverride(name = "textColor", column = @Column(name = "community_bar_text_color")),
                @AttributeOverride(name = "joinButtonColor", column = @Column(name = "community_bar_join_button_color")),
                @AttributeOverride(name = "joinButtonTextColor", column = @Column(name = "community_bar_join_button_text_color")),
                @AttributeOverride(name = "borderColor", column = @Column(name = "community_bar_border_color")),
                @AttributeOverride(name = "border", column = @Column(name = "community_bar_border"))
        })
        private CommunityBar communityBar;

        @Embedded
        @AttributeOverrides({
                @AttributeOverride(name = "aboutBgColor", column = @Column(name = "about_bar_bg_color")),
                @AttributeOverride(name = "aboutTextColor", column = @Column(name = "about_bar_text_color")),
                @AttributeOverride(name = "aboutBorderSize", column = @Column(name = "about_bar_border_size")),
                @AttributeOverride(name = "aboutBorderColor", column = @Column(name = "about_bar_border_color"))
        })
        private AboutBar aboutBar;

        @Embedded
        @AttributeOverrides({
                @AttributeOverride(name = "calenderBgColor", column = @Column(name = "calender_bar_bg_color")),
                @AttributeOverride(name = "calenderTextColor", column = @Column(name = "calender_bar_text_color")),
                @AttributeOverride(name = "calenderBorderColor", column = @Column(name = "calender_bar_border_color")),
                @AttributeOverride(name = "calenderBorderSize", column = @Column(name = "calender_bar_border_size")),
                @AttributeOverride(name = "calenderBoxBgColor", column = @Column(name = "calender_bar_box_bg_color")),
                @AttributeOverride(name = "calenderBoxTextColor", column = @Column(name = "calender_bar_box_text_color")),
                @AttributeOverride(name = "calenderBoxBorderSize", column = @Column(name = "calender_bar_box_border_size")),
                @AttributeOverride(name = "calenderBoxBorderColor", column = @Column(name = "calender_bar_box_border_color"))
        })
        private CalenderBar calenderBar;

        @Embedded
        @AttributeOverrides({
                @AttributeOverride(name = "shareBgColor", column = @Column(name = "share_bar_bg_color")),
                @AttributeOverride(name = "shareTextColor", column = @Column(name = "share_bar_text_color")),
                @AttributeOverride(name = "shareButtonColor", column = @Column(name = "share_bar_button_color")),
                @AttributeOverride(name = "shareButtonTextColor", column = @Column(name = "share_bar_button_text_color")),
                @AttributeOverride(name = "shareBorderColor", column = @Column(name = "share_bar_border_color")),
                @AttributeOverride(name = "shareBorderSize", column = @Column(name = "share_bar_border_size"))
        })
        private ShareBar shareBar;

        @Embedded
        @AttributeOverrides({
                @AttributeOverride(name = "postBgColor", column = @Column(name = "post_bar_bg_color")),
                @AttributeOverride(name = "postTextColor", column = @Column(name = "post_bar_text_color")),
                @AttributeOverride(name = "postButtonColor", column = @Column(name = "post_bar_button_color")),
                @AttributeOverride(name = "postButtonTextColor", column = @Column(name = "post_bar_button_text_color")),
                @AttributeOverride(name = "postBorderColor", column = @Column(name = "post_bar_border_color")),
                @AttributeOverride(name = "postBorderSize", column = @Column(name = "post_bar_border_size"))
        })
        private PostBar postBar;
    
}
