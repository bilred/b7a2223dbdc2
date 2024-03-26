package com.devskiller.tasks.blog.service;

import com.devskiller.tasks.blog.model.Comment;
import com.devskiller.tasks.blog.model.Post;
import com.devskiller.tasks.blog.model.dto.CommentDto;
import com.devskiller.tasks.blog.model.dto.NewCommentDto;
import com.devskiller.tasks.blog.repository.CommentRepository;
import com.devskiller.tasks.blog.repository.PostRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CommentService {

	private final PostRepository postRepository;
	private final CommentRepository commentRepository;

	public CommentService(PostRepository postRepository, CommentRepository commentRepository) {
		this.postRepository = postRepository;
		this.commentRepository = commentRepository;
	}

	/**
	 * Returns a list of all comments for a blog post with passed id.
	 *
	 * @param postId id of the post
	 * @return list of comments sorted by creation date descending - most recent first
	 */
	@Transactional
	public List<CommentDto> getCommentsForPost(Long postId) {
		Optional<Post> post = postRepository.findById(postId);

		if(post.isPresent() && null != post.get().getComments()) {
			return post.get().getComments()
				.stream()
				.map(comment -> new CommentDto(comment.getId(), comment.getComment(), comment.getAuthor(), comment.getCreationDate()))
				.sorted(Comparator.comparing(CommentDto::creationDate))
				.collect(Collectors.toList());
		}

		return Collections.emptyList();
	}

	/**
	 * Creates a new comment
	 *
	 * @param postId id of the post
	 * @param newCommentDto data of new comment
	 * @return id of the created comment
	 *
	 * @throws IllegalArgumentException if postId is null or there is no blog post for passed postId
	 */
	@Transactional
	public Long addComment(Long postId, NewCommentDto newCommentDto) {
		Optional<Post> post = postRepository.findById(postId);

		if(post.isPresent()) {
			Post postWithExistingComments = post.get();
			List<Comment> existingComments = postWithExistingComments.getComments();
			Comment newCommentSaved = commentRepository.save(new Comment(newCommentDto.content(), newCommentDto.author(), LocalDateTime.now()));

			existingComments.add(newCommentSaved);
			postWithExistingComments.setComments(existingComments);
			postRepository.save(postWithExistingComments);

			return newCommentSaved.getId();
		}

		throw new IllegalArgumentException("PostId is null or there is no blog post for passed postId ["+ postId +"]");
	}
}
