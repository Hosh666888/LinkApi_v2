package pro.goforit.service.base.impl;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import pro.goforit.common.entity.domain.Comment;
import pro.goforit.common.exceptions.AuthException;
import pro.goforit.common.exceptions.NoSuchDataException;
import pro.goforit.service.base.ICommentService;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author: Double>J
 * @email: zjj20001031@foxmail.com
 * @editTime: 2022/10/9 15:02
 * @desc:
 **/
@SpringBootTest
class CommentServiceImplTest {
    @Resource
    private ICommentService commentService;

    @Test
    void insertSelective() throws AuthException {
        Comment comment = new Comment();

        comment.setContent("""
                真好呀 嘿嘿嘿
                """);
        comment.setReplyId(124141414L);

        commentService.insertSelective(comment);
    }

    @Test
    void delete() {
        commentService.delete(1579005356060295168L);
    }

    @Test
    void updateSelective() throws NoSuchDataException {
        Comment comment = new Comment();
        comment.setId(1579005356060295168L);
        comment.setReplyId(14141L);
        comment.setArticleId(12414141L);
        commentService.updateSelective(comment);
    }
}