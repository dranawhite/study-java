package com.dranawhite.study.springboot.spring;

import com.dranawhite.common.constants.Separator;
import com.dranawhite.common.exception.DranaSystemException;
import com.dranawhite.common.exception.GenericResultCode;
import com.dranawhite.common.resource.ResourceLoader;
import com.dranawhite.study.springboot.batch.CsvItemProcessor;
import com.dranawhite.study.springboot.batch.CsvItemValidator;
import com.dranawhite.study.springboot.batch.CsvJobListener;
import com.dranawhite.study.springboot.batch.ExcelWriter;
import com.dranawhite.study.springboot.model.user.UserVO;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.support.JobRepositoryFactoryBean;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.batch.item.file.transform.LineTokenizer;
import org.springframework.batch.item.validator.Validator;
import org.springframework.context.annotation.Bean;

/**
 * 此处添加@Configuration @EnableBatchProcessing
 *
 * @author dranawhite
 * @version : BatchConfig.java, v 0.1 2019-07-27 18:25 dranawhite Exp $$
 */
@SuppressWarnings("unchecked")
public class BatchConfig {

    @Bean
    public ItemReader<UserVO> reader() {
        FlatFileItemReader<UserVO> reader = new FlatFileItemReader<>();
        reader.setResource(ResourceLoader.getResource("static/people.csv"));
        DefaultLineMapper lineMapper = new DefaultLineMapper();
        lineMapper.setLineTokenizer(getUserLineTokenizer());
        lineMapper.setFieldSetMapper(getUserFieldSetMapper());
        reader.setLineMapper(lineMapper);
        return reader;
    }

    @Bean
    public ItemProcessor<UserVO, UserVO> processor() {
        CsvItemProcessor processor = new CsvItemProcessor();
        processor.setValidator(validator());
        return processor;
    }

    @Bean
    public ItemWriter<UserVO> writer() {
        return new ExcelWriter();
    }

    @Bean
    public JobRepository batchJobRepository() {
        // jobRepository默认SpringBoot会自动注册
        try {
            JobRepositoryFactoryBean factoryBean = new JobRepositoryFactoryBean();
            return factoryBean.getObject();
        } catch (Exception ex) {
            throw new DranaSystemException("Batch Job错误", GenericResultCode.SYSTEM_ERROR, ex);
        }
    }

    @Bean
    public SimpleJobLauncher batchJobLauncher() {
        // jobLauncher默认SpringBoot会自动注册
        try {
            SimpleJobLauncher jobLauncher = new SimpleJobLauncher();
            jobLauncher.setJobRepository(batchJobRepository());
            return jobLauncher;
        } catch (Exception ex) {
            throw new DranaSystemException("Batch Job错误", GenericResultCode.SYSTEM_ERROR, ex);
        }
    }

    @Bean
    public Job importJob(JobBuilderFactory jobBuilderFactory, Step step) {
        return jobBuilderFactory.get("importJob").incrementer(new RunIdIncrementer()).flow(step).end()
                .listener(csvJobListener()).build();
    }

    @Bean
    public Step step(StepBuilderFactory stepBuilderFactory, ItemReader<UserVO> reader, ItemWriter<UserVO> writer,
                     ItemProcessor processor) {
        return stepBuilderFactory.get("step1").chunk(6000).reader(reader).processor(processor).writer(writer).build();
    }

    @Bean
    public CsvJobListener csvJobListener() {
        return new CsvJobListener();
    }

    @Bean
    public Validator<UserVO> validator() {
        return new CsvItemValidator<>();
    }

    private LineTokenizer getUserLineTokenizer() {
        DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
        lineTokenizer.setNames("id", "name", "address");
        lineTokenizer.setDelimiter(Separator.StringSeparator.COMMA);
        return lineTokenizer;
    }

    private FieldSetMapper getUserFieldSetMapper() {
        BeanWrapperFieldSetMapper fieldSetMapper = new BeanWrapperFieldSetMapper();
        fieldSetMapper.setTargetType(UserVO.class);
        return fieldSetMapper;
    }

}
