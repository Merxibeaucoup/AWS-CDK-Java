package com.myorg;

import software.constructs.Construct;

import java.util.Arrays;

import software.amazon.awscdk.Stack;
import software.amazon.awscdk.StackProps;
import software.amazon.awscdk.services.ecr.LifecycleRule;
import software.amazon.awscdk.services.ecr.Repository;
import software.amazon.awscdk.services.ecr.TagMutability;
// import software.amazon.awscdk.Duration;
// import software.amazon.awscdk.services.sqs.Queue;

public class HelloCdkStack extends Stack {
    public HelloCdkStack(final Construct scope, final String id) {
        this(scope, id, null);
    }

    public HelloCdkStack(final Construct scope, final String id, final StackProps props) {
        super(scope, id, props);

        // The code that defines your stack goes here


        Repository repo = Repository.Builder.create(this, "repository")
        		.repositoryName("hello-world-repository")
        		.imageScanOnPush(Boolean.TRUE)
        		.lifecycleRules(Arrays.asList(LifecycleRule.builder()
        				.maxImageCount(10)
        				.build()))
        		.imageTagMutability(TagMutability.IMMUTABLE)
        		.build();
    }
}
