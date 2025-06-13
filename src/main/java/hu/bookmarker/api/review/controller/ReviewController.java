package hu.bookmarker.api.review.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hu.bookmarker.api.review.model.ReviewDTO;
import hu.bookmarker.api.review.service.ReviewService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping (value = "/review", produces = "application/json")
public class ReviewController {
    
    private final ReviewService reviewService;

    @GetMapping("/")
    public ReviewDTO getMyReview(@RequestParam(required = true, name = "userId") final Integer userId
                               , @RequestParam(required = true, name = "bookSrno") final Integer bookSrno){
        log.info("*** getMyReview *** ");
        ReviewDTO reviewDto = ReviewDTO.builder()
                                    .userId(userId)
                                    .bookSrno(bookSrno).build();
        return reviewService.getMyReview(reviewDto);
    }

    @GetMapping("/list")
    public List<ReviewDTO> getReviews(@RequestParam(required = true, name = "userId") final Integer userId){
        log.info("*** getReviews *** ");
        ReviewDTO reviewDto = ReviewDTO.builder()
                                    .userId(userId)
                                    .build();

        return reviewService.getReviews(reviewDto);
    }

    @PostMapping("/")
    public int createMyReview(@RequestBody final ReviewDTO reqDto) {
        log.info("*** createMyReview *** ");
        ReviewDTO reviewDto = ReviewDTO.builder()
                                    .userId(1)
                                    .reviewRating(reqDto.getReviewRating())
                                    .reviewText("aaaa")
                                    .bookInfo(reqDto.getBookInfo())
                                    .build();
        return reviewService.createMyReview(reviewDto);

    }
}
