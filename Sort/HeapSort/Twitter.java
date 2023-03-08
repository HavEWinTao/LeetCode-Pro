import java.util.*;

/**
 * @author fantastic
 */
public class Twitter {

    private Map<Integer, Heap<int[]>> posts;

    private Map<Integer, Set<Integer>> followers;

    private int cnt = 0;

    public Twitter() {
        posts = new HashMap<>();
        followers = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        Heap<int[]> userPost;
        if (posts.containsKey(userId)) {
            userPost = posts.get(userId);
        } else {
            userPost = new Heap<>((o1, o2) -> o1[1] - o2[1]);
            posts.put(userId, userPost);
        }
        userPost.add(new int[]{tweetId, cnt++});
    }

    public List<Integer> getNewsFeed(int userId) {
        Set<Integer> follower = followers.get(userId);
        int size = Objects.isNull(follower) ? 0 : follower.size();
        Heap<int[]>[] followeePosts = new Heap[size + 1];
        int index = 0;
        if (size != 0) {
            for (int i : follower) {
                if (posts.containsKey(i)) {
                    followeePosts[index++] = new Heap<>(posts.get(i));
                }
            }
        }
        if (posts.containsKey(userId)) {
            followeePosts[index] = new Heap<>(posts.get(userId));
        }
        Heap<Heap<int[]>> heap = new Heap<>(followeePosts, (o1, o2) -> {
            if (Objects.isNull(o1) || o1.size() == 0) {
                return -1;
            }
            if (Objects.isNull(o2) || o2.size() == 0) {
                return 1;
            }
            return o1.top()[1] - o2.top()[1];
        });
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Heap<int[]> temp = heap.pop();
            if (Objects.isNull(temp) || temp.size() == 0) {
                break;
            }
            ans.add(temp.pop()[0]);
            heap.add(temp);
        }
        return ans;
    }

    public void follow(int followerId, int followeeId) {
        Set<Integer> follower;
        if (followers.containsKey(followerId)) {
            follower = followers.get(followerId);
        } else {
            follower = new HashSet<>();
            followers.put(followerId, follower);
        }
        follower.add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        Set<Integer> follower = followers.get(followerId);
        if (Objects.nonNull(follower)) {
            follower.remove(followeeId);
        }
    }

    public static void main(String[] args) {
        Twitter obj = new Twitter();
        obj.postTweet(1, 7);
        obj.postTweet(1, 5);
        System.out.println(obj.getNewsFeed(1));
        obj.follow(1, 2);
        obj.postTweet(2, 6);
        System.out.println(obj.getNewsFeed(1));
        obj.unfollow(1, 2);
        System.out.println(obj.getNewsFeed(1));
    }
}
