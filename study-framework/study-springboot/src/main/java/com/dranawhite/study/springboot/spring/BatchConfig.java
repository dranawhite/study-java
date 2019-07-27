package com.dranawhite.study.springboot.spring;

import com.dranawhite.common.constants.Separator;
import com.dranawhite.common.exception.DranaRuntimeException;
import com.dranawhite.common.exception.ResultCodeEnum;
import com.dranawhite.common.resource.ResourceLoader;
import com.dranawhite.study.springboot.batch.CsvItemProcessor;
import com.dranawhite.study.springboot.batch.CsvItemValidator;
import com.dranawhite.study.springboot.batch.CsvJobListener;
import com.dranawhite.study.springboot.batch.ExcelWriter;
import com.dranawhite.study.springboot.model.user.UserVO;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
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
import org.springframework.context.annotation.Configuration;

/**
 * @author liangyuquan
 * @version : BatchConfig.java, v 0.1 2019-07-27 18:25 liangyuquan Exp $$
 */
@Configuration
@EnableBatchProcessing
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
    public JobRepository jobRepository() {
        try {
            JobRepositoryFactoryBean factoryBean = new JobRepositoryFactoryBean();
            return factoryBean.getObject();
        } catch (Exception ex) {
            throw new DranaRuntimeException("Batch Job错误", ResultCodeEnum.SYSTEM_ERR, ex);
        }
    }

    @Bean
    public SimpleJobLauncher jobLauncher() {
        try {
            SimpleJobLauncher jobLauncher = new SimpleJobLauncher();
            jobLauncher.setJobRepository(jobRepository());
            return jobLauncher;
        } catch (Exception ex) {
            throw new DranaRuntimeException("Batch Job错误", ResultCodeEnum.SYSTEM_ERR, ex);
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
        lineTokenizer.setDelimiter(Separator.COMMA);
        return lineTokenizer;
    }

    private FieldSetMapper getUserFieldSetMapper() {
        BeanWrapperFieldSetMapper fieldSetMapper = new BeanWrapperFieldSetMapper();
        fieldSetMapper.setTargetType(UserVO.class);
        return fieldSetMapper;
    }

}
