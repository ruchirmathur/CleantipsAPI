package com.cleantips.template;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.amazonaws.services.ec2.model.DescribeImagesRequest;
import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.ec2.AmazonEC2ClientBuilder;
import com.amazonaws.services.ec2.model.AvailabilityZone;
import com.amazonaws.services.ec2.model.DescribeAvailabilityZonesRequest;
import com.amazonaws.services.ec2.model.DescribeAvailabilityZonesResult;
import com.amazonaws.services.ec2.model.DescribeRegionsResult;
import com.amazonaws.services.ec2.model.DescribeReservedInstancesOfferingsRequest;
import com.amazonaws.services.ec2.model.DescribeReservedInstancesOfferingsResult;
import com.amazonaws.services.ec2.model.Image;
import com.amazonaws.services.ec2.model.Region;
import com.amazonaws.services.ec2.model.ReservedInstancesOffering;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.CopyObjectRequest;
import com.amazonaws.services.s3.model.CopyObjectResult;
import com.amazonaws.services.s3.model.GetBucketLocationRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.cleantips.ec2.instance.model.AvailibilityZone;
import com.cleantips.ec2.instance.model.BlockDeviceMappings;
import com.cleantips.ec2.instance.model.Ebs;
import com.cleantips.ec2.instance.model.ElasticInferenceAccelerators;
import com.cleantips.ec2.instance.model.Instance;
import com.cleantips.ec2.instance.model.NetworkInterfaces;
import com.cleantips.ec2.instance.model.Parameter;
import com.cleantips.ec2.instance.model.Properties;
import com.cleantips.ec2.instance.model.Ref;
import com.cleantips.vpc.eip.model.EIP;
import com.cleantips.vpc.gateway.model.VpcGateway;

// TODO: Auto-generated Javadoc
/**
 * The Class Util.
 */
public class Util {

	/**
	 * Gets the bucket location.
	 *
	 * @param map the map
	 * @param region the region
	 * @param file the file
	 * @param type the type
	 * @return the bucket location
	 */
	public static String getBucketLocation(HashMap map, String region, File file, String type) {

		String bucketName = "Stack";

		String finalBucketName = type;

		System.out.println("bucker nme::::" + finalBucketName);

		final AmazonS3 s3 = AmazonS3ClientBuilder.defaultClient();

		if (!s3.doesBucketExistV2(finalBucketName)) {

			System.out.println("finalBucketName nme::::" + finalBucketName);

			Bucket bucket = s3.createBucket(finalBucketName);
			// Upload a file as a new object with ContentType and title specified.

		}
		PutObjectRequest request = new PutObjectRequest(finalBucketName, type, file);
		ObjectMetadata metadata = new ObjectMetadata();
		metadata.setContentType("plain/text");
		metadata.addUserMetadata("x-amz-meta-title", "someTitle");
		request.setMetadata(metadata);
		s3.putObject(request);
		System.out.println("finalBucketName nme::all::" + finalBucketName);
		String bucketLocation = s3.getUrl(finalBucketName, type).toExternalForm();
		System.out.println("bucketLocation nme::::" + bucketLocation);
		return bucketLocation;

	}

}
